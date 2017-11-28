<?php $this->load->helper('url'); ?>
<html>
<head>
	<title>Raspberry Pi Examples for BlueJ</title>
	
	<!-- Meta data -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Raspberry Pi Examples for BlueJ">
	<meta name="author" content="ojp5@kent.ac.uk, hs308@kent.ac.uk, jp481@kent.ac.uk">
	
	<!-- Old method of adding CSS - Kept just incase we need to disable minification
	<link href="<?php echo base_url()."public/css/bootstrap.min.css";?>" rel="stylesheet">
	<link href="<?php echo base_url()."public/css/bootstrap-theme.css";?>" rel="stylesheet">
	<link href="<?php echo base_url()."public/css/font-awesome.min.css";?>" rel="stylesheet">
	<link href="<?php echo base_url()."public/css/joint.css";?>" rel="stylesheet">
	<link href="<?php echo base_url()."public/css/styles.css";?>" rel="stylesheet"> -->

	<!--Minified CSS -->
	<?php 
		$this->minify->css(array('bootstrap.min.css', 'bootstrap-theme.css', 'font-awesome.min.css', 'joint.css', 'styles.css'));
		echo $this->minify->deploy_css(TRUE); 
	?>

	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<?php echo base_url()."/public/js/bootstrap.min.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/lodash.min.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/backbone-min.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/graphlib.min.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/dagre.core.min.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/joint.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/joint.layout.DirectedGraph.js";?>"></script>
	<script src="<?php echo base_url()."/public/js/custom.js";?>"></script>
</head>

<!-- Background Image from http://www.bluej.org/ to keep to their theme -->
<body style="background-image: url('<?php echo base_url()."public/images/clouds.png";?>');">
	<div class="container">
		