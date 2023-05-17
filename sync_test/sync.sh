function killckb {
PROCESS=`ps -ef|grep /ckb|grep -v grep|awk '{print $2}' | sed -n '2,10p'`
for i in $PROCESS
do
  echo "killed the ckb $i"
  sudo kill -9 $i
done
}

killckb

cd $path
sudo rm -rf data

sleep 1m

cd $path
sudo nohup ./ckb run &
sleep 20h

killckb

#PROCESS=`ps -ef|grep /ckb|grep -v grep|awk '{print $2}' | sed -n '2,10p'`
#for i in $PROCESS
#do
  #echo "killed the ckb $i"
 # sudo kill -9 $i
#done

# sh /home/baoleiji/yace/run_yace.sh