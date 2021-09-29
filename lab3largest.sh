#!/bin/sh
echo "num 1"
read n1
echo "num2"
read n2
echo "num3"
read n3
if [ $n1 -gt $n2 ] && [ $n1 -gt $n3 ]
then
    echo $n1
elif [ $n2 -gt $n1 ] && [ $n2 -gt $n3 ]
then
    echo $n2
else
    echo $n3
fi
