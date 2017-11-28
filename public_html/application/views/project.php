<!-- Pi Examples for BlueJ Website. Powered by Codeigniter. Authors: Oliver Pechey, Harry Schneider and James Pierce. Copyright University of Kent -->
<!--Get Header -->

<?php $this->load->view('header'); ?>
<div class="row">
<div class="col-md-12">

<!-- Back Button -->
<a href="<?php echo site_url('');?>"><img class="back" src="<?php echo base_url()."public/images/back.png";?>"></a>

<!-- Title -->
<h1 class="text-center"><?php echo $project_name; ?></h1>

<div class="row">
<div class="text-center col-md-6">

<!--Project Details -->

<h2>Description</h2>
<p style="padding-left:10px;">
	<?php echo $description; ?>
	</p>

<h2>Parts Required</h2>
<ul class="left-align">
	<?php echo $parts_required; ?>
</ul>

<h2>Assembly Instructions</h2>
<ol class="left-align">
	<?php echo $assembly_instructions; ?>
</ol>

<!-- May not exist, since is optional field -->
<?php if($notes != "") { ?>
<h2>Notes</h2>
<ul class="left-align">
	<?php echo $notes; ?>
	</ul>
<?php } ?>

<h2>Project Download</h2>
<ul class="left-align">
<li><a href="<?php echo site_url('/public/downloads/'.$download);?>">Core Classes</a></li>
<!-- May not exist, since is optional field -->
<?php if($download2 != "") { ?>
<li><a href="<?php echo site_url('/public/downloads/'.$download2);?>">Core Classes, Tutorials and Exercises</a></li>
<!-- May not exist, since is optional field -->
<?php } if($download3 != "") { ?>
<li><a href="<?php echo site_url('/public/downloads/'.$download3);?>">Core Classes, Tutorials, Exercises and Answers</a></li>
<?php } ?>
</ul>

</div>

<div class="text-center col-md-6">
<h2>Assembly Diagram</h2>
<img class="img-responsive" src="<?php echo site_url('/public/images/diagrams/'.$assembly_diagram); ?>">

</div>
</div>

</div>
</div>

<?php $this->load->view('footer'); ?>