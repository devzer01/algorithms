<?php 

$string = "abcd";

function swap(&$str, $x, $y)
{
	$temp = $str[$x];
	$str[$x] = $str[$y];
	$str[$y] = $temp;
}

function permutate($str, $start)
{
	if ($start == strlen($str) - 1) echo str;
	else {
		for ($i = $start; $i < strlen($str) - 1; $i++) {
			swap($str, $start, $i);
			permutate($str, $start+1);
		}
	}
}

