#!/bin/sh
echo "enter number to get factorial"
read num
f=1






while [ "$num" -gt 1 ] 
do

  f=$((f * num))
  num=$((num - 1))
done
echo $f
