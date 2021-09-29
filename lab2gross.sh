#!/bin/sh
gross_salary=0
da=0
ta=0
echo "enter your basic salary"
read basic














da=$(((10/100)*$basic)) 












ta=$(((12*$basic)/100))

gross_salary=$(($basic+$da+$ta))
echo "gross=$gross_salary" 
