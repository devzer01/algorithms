<?php 


function doCombine($str, $outstr, $index)
{
	for ($i = $index; $i < strlen($str); $i++ ) {
		$outstr[] = $str[$i];
		
		echo implode("", $outstr) . "\n";
		
		if ($i < strlen($str) - 1) {
			doCombine($str, $outstr, $index + 1);
		}
		array_pop($outstr);
	}	
}