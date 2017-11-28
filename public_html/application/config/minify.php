<?php
/**
 * Minify config Class
 *
 * PHP Version 5.3
 *
 * @category  PHP
 * @package   Controller
 * @author    Slawomir Jasinski <slav123@gmail.com>
 * @copyright 2015 All Rights Reserved SpiderSoft
 * @license   Copyright 2015 All Rights Reserved SpiderSoft
 * @link      http://www.spidersoft.com.au/projects/codeigniter-minify/
 */

defined('BASEPATH') OR exit('No direct script access allowed');


/**
 * Minify config file
 *
 * @category  PHP
 * @package   Controller
 * @author    Slawomir Jasinski <slav123@gmail.com>
 * @copyright 2015 All Rights Reserved SpiderSoft
 * @license   Copyright 2015 All Rights Reserved SpiderSoft
 * @link      http://www.spidersoft.com.au/projects/codeigniter-minify/
 */

$config['assets_dir'] = 'public';
$config['css_dir']    = 'public/css';
$config['js_dir'] = 'public/js';

$config['compression_engine'] = array(
	'css' => 'minify', // minify || cssmin
	'js'  => 'jsminplus' //'closurecompiler' // jsmin || closurecompiler || jsminplus
);


// optimization level (can be "WHITESPACE_ONLY", "SIMPLE_OPTIMIZATIONS" or "ADVANCED_OPTIMIZATIONS")
$config['closurecompiler']['compilation_level'] = 'SIMPLE_OPTIMIZATIONS';



// End of file minify.php
// Location: ./application/config/minify.php
