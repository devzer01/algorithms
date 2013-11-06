<?php 

class BST {
	
	public $parent = null;
	
	public function add($value) {
		$this->parent = $this->add2($this->parent, $value);
	}
	
	public function add2($node, $value) {
		
		if (is_null($node)) {
			$node = new Node();
			$node->value = $value;
		}
		
		if ($node->value > $value) {
			$node->left = $this->add2($node->left, $value);
		}
		
		if ($node->value < $value) {
			$node->right = $this->add2($node->right, $value);
		}
		
		return $node;
	}
	
}

class Node {
	
	public $left = null;
	
	public $right = null;
	
	public $value = null;
	
	
}