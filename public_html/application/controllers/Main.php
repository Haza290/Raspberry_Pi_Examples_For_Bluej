<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Main extends CI_Controller {

	public function __construct()
       {
            parent::__construct();
            //Load Minification Library and Model on every page.
            $this->load->library('minify'); 
			$this->load->model('Projects_model');
       }

	public function index()
	{
		header('Access-Control-Allow-Origin: *');
		$data['projects'] = $this->Projects_model->getTreeData();
		$data['images'] = $this->Projects_model->getAllImages();
		//var_dump($data);
		$this->load->view('home',$data);
	}

	public function project($project) 
	{
		$data = $this->Projects_model->getProjectData($project);
		//var_dump($data);
		$this->load->view('project',$data );
	}
}
