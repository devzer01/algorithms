<?php
$word = "abc";

//purmutex($word, 0, strlen($word) - 1);

/* $array = array(3,6,8,3,2,6,9,11,23,25,10);
sort($array);
var_dump($array);
var_dump(binarySearch($array, 0, count($array) - 1, 10)); */

//echo josephus2(7, 2);
$result = "";
//getphonechars("8662665", 0, $result);

//doCombine($word, $result, 0);

$array = array(0,1,3,6,8,3,2,6,9,11,23,25,10);
//sort($array);
//var_dump($array);
// var_dump(largerThanK($array, 0, count($array) - 1, 25));
//var_dump(valueAsSame($array, 0, count($array) - 1));

var_dump(selectionSort($array));

function swap(&$word, $xpos, $ypos)
{
	$temp = $word[$xpos];
	$word[$xpos] = $word[$ypos];
	$word[$ypos] = $temp;
}

function purmutex($word, $xpos, $ypos)
{
	
	if ($xpos == $ypos) {
		echo $word . "\n";
	} else {	
		for ($j = $xpos; $j <= $ypos; $j++) {
			swap($word, $xpos, $j);
			purmutex($word, $xpos+1, $ypos); //CBA -> CAB -> 
			//swap($word, $xpos, $j);			
		}
	}
}

function binarySearch($array, $start, $end, $needle)
{
	if ($start > $end) return false;
	$mid = (int) ($start + ($end - $start)/ 2);
	if ($needle == $array[$mid]) return $mid;
	else if ($needle < $array[$mid]) return binarySearch($array, $start, $mid - 1, $needle);
	else if ($needle > $array[$mid]) return binarySearch($array, $mid + 1, $end, $needle);
}

function josephus($n, $k, $i) {
     if($n == 1)
         return 1;
     $sp = ($i + $k - 2) % $n + 1;
     $survivor = josephus($n - 1, $k, $sp);
     if ($survivor < $sp) {
         return $survivor;
     } else {
         return $survivor + 1;
 	}
}

function josephus2($n, $k)
{
	if ($n == 1)
		return 1;
	else
		return (josephus2($n - 1, $k) + $k-1) % $n + 1;
}

function getChar($digit, $index)
{
	$array[0] = array(0,0,0,0);
	$array[1] = array(1,1,1,1);
	$array[2] = array(0, 'A', 'B', 'C');
	$array[3] = array(0, 'D', 'E', 'F');
	$array[4] = array(0, 'G', 'H', 'I');
	$array[5] = array(0, 'J', 'K', 'L');
	$array[6] = array(0, 'M', 'N', 'O');
	$array[7] = array(0, 'P', 'R', 'S');
	$array[8] = array(0, 'T', 'U', 'V');
	$array[9] = array(0, 'W', 'X', 'Y');
	
	return $array[$digit][$index];
}

function getphonechars($number, $i, &$result)
{
	if ($i == strlen($number)) {
		echo implode("", $result) . "\n";
		return;
	}
	
	for ($x=1; $x<=3; $x++) {
		$result[$i] = getChar($number[$i], $x);
		getphonechars($number, $i + 1, $result);
		if ($number[$i] == 0 || $number[$i] == 1) return;
	}	
}
/*
 * ABC
 * A, AB, ABC
 * B, 
 */
function doCombine($str, $outstr, $start)
{
	for ($i = $start; $i < strlen($str); $i++) {
		$outstr[] = $str[$i];
		echo implode("", $outstr) . "\n";
		
		if ($i < (strlen($str) - 1)) {
			doCombine($str, $outstr, $i + 1);
		}
		array_pop($outstr);
	}
}

function largerThanK($arr, $start, $end, $value)
{
	if ($start > $end) return -1;
	$mid = (int) ($start + ($end - $start) / 2);
	if ($arr[$mid] == $value) {
		while ($mid < count($arr) - 1 && $arr[++$mid] <= $value) $null = null;
		return ($mid >= count($arr) - 1) ? -1 : $mid;
	} else if ($arr[$mid] < $value) {
		return largerThanK($arr, $mid + 1, $end, $value);
	}
	else return largerThanK($arr, $start, $mid - 1, $value);
}

function valueAsSame($arr, $start, $end)
{
	if ($start > $end) return -1;
	$mid = (int) ($start + ($end - $start) / 2);
	if ($arr[$mid] == $mid) {
		return $mid;
	} else if ($arr[$mid] < $mid) {
		return valueAsSame($arr, $mid + 1, $end);
	}
	else return valueAsSame($arr, $start, $mid - 1);
}

function bstSearchRec($node, $value)
{	
	while ($node != null) {
		if ($value < $node->value) {
			$node = $node->left;
		} else if ($value > $node->value) {
			$node = $node->right;
		} else {
			return $value;
		}
	}
	
	return -1;
}


function combinations($str, $result, $start)
{
	
	for ($i=$start; $i < strlen($str) - 1; $i++) {
	
		$result[] = $str[$i];
		echo $result;
		
		if ($start < strlen($str)) {
			combinations($str, $result, $i + 1);
		}
	
		array_pop($result);
	}	
}

function selectionSort($array) {
	$N = count($array);
	if ($N == 1) return $array;
	
	for ($i = 0; $i < $N; $i++) {
		$min = $i;
		
		for ($j=$i + 1; $j < $N; $j++) 
			if ($array[$j] < $array[$min]) $min = $j;
		swap($array, $i, $min);
		
	}
	
	return $array;
}