#!/bin/sh




read x
case "$x" in  
"1") echo "Monday" ;;
"2") echo "Tuesday" ;;
"3") echo "Wednesday" ;;
"4") echo "THrusday" ;;
"5") echo "Friday" ;;
"6") echo "Saturday" ;;
"7") echo "Sunday" ;;
*) echo "invalid input" ;;

esac
