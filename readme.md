docker build -t payara-ear .
docker run -p 8080:8080 -p 4848:4848 payara-ear

docker build -t payara-ear-443 .

docker run -p 80:80 -p 8080:8080 -p 4848:4848 payara-ear-443

ec2-34-227-242-171.compute-1.amazonaws.com
Administrator
d&tHufZN&f1RIX!Yem=kJOC3IwuPellc
