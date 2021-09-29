#!/bin/sh
echo "enter number to check even/odd="
read x
if [ $((x%2)) -eq 0 ]
then 


   echo "Even"
else 
   echo "Odd no."
fi 
