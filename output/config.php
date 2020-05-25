<?php

# Configuration goes here
$config = array();

# Uncomment this line if you want to use Mysql, in format: array("host","login","password","database");
$config['mysql'] = array("mysql3.1blu.de","sql69945_675787","AlAgA1bdi#08", "db69945x675787");

# To use old SQLite2 (instead of SQLite3) uncomment the line below
#$config['sqlite'] = 2;

# Language pack
$config['lang'] = "de";

# Specify password here to protect your tasks from modification,
#  or leave empty that everyone could read/write todolist
$config['password'] = "Kono2Machi3";

# Restrict access for the others when password above is set:
#  "no" - No access, "read" - Read only
$config['allow'] = "no";

# To disable smart syntax uncomment the line below
#$config['smartsyntax'] = 0;

# To disable auto detecting user time zone uncomment the line below
#$config['autotz'] = 0;

# To disable auto adding selected tag  comment out the line below or set value to 0
$config['autotag'] = 1;

# duedate calendar format: 1 => y-m-d (default), 2 => m/d/y, 3 => d.m.y
$config['duedateformat'] = 3;

# select session handling mechanism: files or default (php default)
$config['session'] = 'default';

$config['persistent.allow'] = 'yes';
$config['persistent.secret'] = 'Z6N9JAe82B3pkVf02gnccn8g6r89Mb6k3x517vCd';
$config['persistent.timeout'] = 60*60*24*7;

?>