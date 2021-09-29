#!/bin/sh
echo "menu 1.list of files  2.Process Status  3.Date  4.user in programme 5.Quit"
read i 

case "$i" in



"1") ls ;;

"2") ps ;; 
"3") date ;;
"4") uname ;;
"5") exit ;;
*) echo "incorrect" ;;
esac




