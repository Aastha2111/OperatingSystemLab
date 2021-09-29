#!/bin/sh
echo "Enter number of element"
read n
i=1

sum=0




while [ $i -le $n ]
do
  echo "enter your number"
  read num 

  sum=$((sum+num))
  i=$((i+1))
done



avg=$(($sum/$n))


 
echo $sum 
echo $avg

