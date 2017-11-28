<?php

class Projects_model extends CI_Model {

	public function __construct() {
		$this->load->database();
	}

	// Returns Names of all projects CHANGE TO STRINGS
	private function getProjects() {
		$this->db->select('project_name');
		$query = $this->db->get('Projects');
		
		return $query->result();
	}

	// Returns all the data for a project add in prev and further
	public function getProjectData($projectName) {
		$query = $this->db->get_where('Projects',array('project_name' => $projectName));
		$res = $query->result();
		
		$res[0] -> prev = $this->getPreviousProjects($projectName);
		//$res[0] -> further = $this->getFurtherProjects($projectName);
		//$res[0] -> image = $this->getImages($projectName);
				
		return $res[0];		
	}
	
	// Returns Previous projects CHANGE TO private
	private function getPreviousProjects($projectName) {
		$query = $this->db
			->select('previous_project')
			->from('Previous_Projects')
			->where('project_name', $projectName)
			->get();
			
		$previousProjects = $query->result();
			
		$prevProjectString = array();
		
		foreach ($previousProjects as $prev) {
			$prevProjectString[] = $prev -> previous_project;
		}
			
		return $prevProjectString;
	}
		
	// Returns data for tree view
	public function getTreeData() {
		
		// Creates an empty array to be filled
		$array = array();
		
		// For each project find all of its previous projects and chuck them (and name of the project) into
		// the array
		foreach ($this->getProjects() as $project) {
			
			// Grabs name of Project
			$previousProjects = $this->getPreviousProjects($project->project_name);
			
			// Combines Project name and array of previous projects
			$combo = array($project->project_name, $previousProjects); 
			$array[] = $combo;			
		}
		return $array;
	}


	// Gets image file names and captions for slider on front page
	public function getAllImages() {
		$this->db->select('image,caption');
		$query = $this->db->get('Images');
		// Creates an empty array to be filled
		$array = array();
		foreach($query->result() as $image) {
			$array[] = array($image->image, $image->caption);
		}
		return $array;
	}
}
?>