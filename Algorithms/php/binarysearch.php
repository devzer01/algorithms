<?php 

$array = array(1,2,3,4,5,6,7,8,4,3,65,76,2,1,3,5,7,89,3,54,3,2,1,4,3,23,5,7,888,4,323);
sort($array);
echo count($array) . "\n";
$key = binarySearch($array, 89);
echo $key . "\n";

function binarySearch($array, $key)
{
	$start = 0;
	$end = count($array) - 1;
	while ($start <= $end) {
		$middle = (int) ($start + (($end - $start) / 2));
		if ($array[$middle] == $key) return $middle;
		else if ($array[$middle] < $key) $start = $middle + 1;
		else if ($array[$middle] > $key) $end = $middle - 1;
	}
	
	return -1;
	
}