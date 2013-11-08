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
	
	public function getLowestCommonAnscestor($value1, $value1) {
		return $this->getLowestCommonAns($this->parent, $value1, $value2);
	}
	
	private function getLowestCommonAns($node, $value1, $value2) {
		if ($node->value < $value1 && $node->value < $value2) {
			return $this->getLowestCommonAns($node->right, $value1, $value2);
		} else if ($node->value > $value1 && $node->value > $value2) {
			return $this->getLowestCommonAns($node->left, $value1, $value2);
		} else {
			return $node->value;
		}
	}
	
	public function preOrder($node) {
		
		print $node->value;
		
		if (!is_null($node->left)) $this->preOrder($node->left);
		
		if (!is_null($node->right)) $this->preOrder($node->right);
		
		return;
	}
	
	public function breadthFirst() 
	{
		
		$queue = array($this->parent);
		
		while (count($queue) > 0) {

			$node = array_shift($queue);
			
			print $node->value;
			
			if ($node->left !== null) array_push($queue, $node->left);
			if ($node->right !== null) array_push($queue, $node->right);			
		}
		
	}
	
}

class Node {
	
	public $left = null;
	
	public $right = null;
	
	public $value = null;
	
	
}