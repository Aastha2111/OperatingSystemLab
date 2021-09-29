#!/bin/sh
echo "enter num to chck prime/non-prime"
read p
for((i=2; i<=p/2; i++))
do
  if [ $((p%i)) -eq 0 ]
  then 
     echo "is not prime"
     exit
   fi
done





echo "is prime"



