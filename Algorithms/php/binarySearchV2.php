<?php 

$array = array(1,2,4,76,4,2,21,4,56,67,4,2,21,5,7,8,456,3,32,5,5,467,57,868,8,5,3,35,7,68,4,63,535,36,68,68);
sort($array);

function binarySearchRec($array, $key, $start, $end)
{
	if ($start > $end) return - 1;
	$mid = (int) ($start + ($end - $start) / 2)
	if ($array[$mid] == $key) return $mid;
	if ($array[$mid] < $key) return binarySearch($array, $key, $mid + 1, $end);
	if ($array[$mid] > $key) return binarySearch($array, $key, $start, $mid - 1);
}