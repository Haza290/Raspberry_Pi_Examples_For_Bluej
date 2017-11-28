<?php $this->load->helper('url');
$this->load->view('header'); ?>
<div class="row">
	<div class="col-md-8">
		<h1 class="head-space">Raspberry Pi Examples for BlueJ</h1>
		<p>Fun and interesting ways to using BlueJ on your Raspberry Pi. Our examples are aimed at people with a basic understanding of Java.</p>
		<p><a href="<?php echo base_url()."public/images/pins.png";?>">Click here</a> for a pinout reference diagram for the Pi.</p>
		<p>You can download a compilation of our projects, or browse them below. <a href="<?php echo base_url()."public/downloads/all_examples.zip";?>"><i class="fa fa-download"></i></a></p>
	</div>
	<div class="col-md-4">
		<img class="img-responsive" src="<?php echo base_url()."public/images/bluej-icon-256.png";?>" style="margin: auto;">
	</div>
</div>
<hr>

<div class="row">
<h2 class="head-space text-center">Projects</h2>
	<h4 class="text-center">Browse a list of our example projects here. Ones at the beginning of the tree are used by the ones that branch out of it.</h4>
	<div class="col-md-12">
		<div id="myholder"></div>
		<script>
	//Initialize Graph
	var projects = [];
	var links = [];
	var rectangles = [];
	var graph = new joint.dia.Graph;
	var paper = new joint.dia.Paper({
		el: $('#myholder'),
		width: $(".col-md-12").width(),
		height: $(".col-md-12").width()/25*9,
		model: graph,
		gridSize: 1,
		interactive: false
	});

	//Hides all the extra stuff the library gives us that we don't need
	var attrObject = {
		'.connection': {display:"none"},
		'.marker-target': {display:"none"}, 
		'text': {display:"none"},
		'rect': {display:"none"},
		'.connection-wrap': {display:"none"},
		'g.marker-vertices': {display:"none"}, 
		'g.link-tools': {display: 'none'},
		'g.marker-arrowheads': {display:"none"}
	};
	
	//Create hidden root object
	var rect = new joint.shapes.basic.Rect({
		size: { width: 100, height: 30 },
		attrs: { rect: { display: 'none' }}
	});
	rectangles.push(rect);

	//Define custom object for projects and make them linkable
	joint.shapes.custom = {};
	joint.shapes.custom.ElementLink = joint.shapes.basic.Rect.extend({
		markup: '<a><g class="rotatable"><g class="scalable"><rect/></g><text/></g></a>',
		defaults: joint.util.deepSupplement({
			type: 'custom.ElementLink'
		}, joint.shapes.basic.Rect.prototype.defaults)
	});

	<?php 

	foreach ($projects as $proj) { ?>

		//Create custom object for each project
		var rect = new joint.shapes.custom.ElementLink({
			size: { width: 115, height: 50 },
			attrs: {
				rect: { fill: '#f5d0a5', stroke: '#000', 'stroke-width': 2 },
				a: { 'xlink:href': 'http://raptor.kent.ac.uk/proj/co600/project/c06_bluerasp/index.php/main/project/<?php echo $proj[0];?>', 'xlink:show': 'current', cursor: 'pointer' },
				text: { text: '<?php echo $proj[0];?>', fill: 'black' }
			}
		});

		//Put Rectangle, Previous Array, and Title into Projects Array
		projects.push(new Array(rect,
			<?php if(sizeof($proj[1]) > 0) { 
				//Start array
				echo "[";
				//Contents of Previous Array
				for($n = 0; $n < sizeof($proj[1]); $n++ ){
					echo "\"".$proj[1][$n]."\"";
					//If not last, add comma
					if($n < sizeof($proj[1])-1) {
						echo ",";
					}
				}
				//End array
				echo "]";
			}
				//Blank array for nothing
			else {
				echo "new Array()"; 
			}
			echo ",\"".$proj[0]."\""; ?>)
		); 
		//Add rectangle to graph
		rectangles.push(rect);

		<?php
	}
	?>

//If a project has previous projects, this will create a link to the object that was made for it.
for (i = 0; i < projects.length; i++) {
	//Checks that the prev array is populated
	if(projects[i][1].length > 0) {
		//Iterates through the previous array
		for(y = 0; y < projects[i][1].length; y++) {
			//ID to assign to target
			for(z = 0; z < projects.length; z++) {
				if(projects[z][2] == projects[i][1][y]) {
					var link = new joint.dia.Link({
						source: { id: projects[i][0].id },
						target: { id: projects[z][0].id }
					});
					links.push(link);
				}
			}
		}
	}
	//if there is no previous projects, link the project to the hidden root element
	else {
		var link = new joint.dia.Link({
			source: { id: rectangles[0].id },
			target: { id: projects[i][0].id },
			interactive: false
		});
		link.attr(attrObject);
		links.push(link);
	}
}
//Combine arrays and add the whole thing to graph.
graph.resetCells(rectangles.concat(links));
//Graph layout options
var graphLayout = joint.layout.DirectedGraph.layout(graph, {
	nodeSep: 25,
	edgeSep: 80,
	rankDir: "BT"
});
</script>
</div>
</div>

<div class="row">
<hr>
<h2 class="head-space text-center">Photos</h2>
<ul class="gallery">
<?php
$first = true;
foreach($images as $filename){
	if($first) {
		echo '<li><img class="img-responsive" src="'.base_url().'public/images/photos/'.$filename[0].'">';
		$first = false;
	}
	else {
		echo '<li style="display:none;"><img class="img-responsive" src="'.base_url().'public/images/photos/'.$filename[0].'">';
	}
	echo '<div class="caption"><p>'.$filename[1].'</p></div></li>';
 }
 ?>
</ul>
</div>
<?php $this->load->view('footer'); ?>