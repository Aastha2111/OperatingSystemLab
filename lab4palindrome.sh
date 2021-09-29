#!/bin/sh
echo "enter num:"
read num
temp=$num
rev=0

while [ $num -gt 0 ]
do
r=`expr $num % 10`

rev=`expr $rev \* 10 + $r` 



num=`expr $num / 10`


done
echo $rev

if [ $temp -eq $rev ]
then 
 echo "is Palindrome"
else
 echo "not Palindrom"
fi


