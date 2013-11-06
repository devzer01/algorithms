<?php

$string = "abc";

permute($string, 0);

function swap(&$str, $x, $y)
{
	$temp = $str[$x];
	$str[$x] = $str[$y];
	$str[$y] = $temp;
}

function permute($str, $start)
{
	if ($start == strlen($str) - 1) echo $str . "\n";
	else {
		for ($i = $start; $i <= strlen($str) - 1; $i++) {
			swap($str, $start, $i);
			permute($str, $start+1);
		}
	}
}


