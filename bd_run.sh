#!/bin/bash
echo " "
echo "-------------------------------"
echo "Implantando o banco de dados..."
echo "-------------------------------"
echo " "
docker build -t starwarsapi/bd ./postgres
docker run -p 5433:5432 --name swapibd -d starwarsapi/bd
#docker logs bd
echo "Aguarde..."
echo " "
sleep 5
echo "Concluído. Container do banco de dados implantando."
echo " "

