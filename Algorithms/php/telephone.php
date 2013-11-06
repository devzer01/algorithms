<?php 

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


function getPhoneChar($number, $index, &$result)
{
	if ($index == strlen($number)) {
		echo implode("", $result);
		return true;
	}
	
	for ($i = 1; $i <= 3; $i++) {
		$result[$index] = getChar($number[$index], $i);
		getPhoneChar($number, $index + 1, $result);
		if ($number[$index] == 1 || $number[$index] == 0) return;
	}
}