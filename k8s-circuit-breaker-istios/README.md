kubectl apply -f samples/httpbin/httpbin.yaml
kubectl apply -f destination_rule_circuit_breaker.yaml
kubectl get destinationrule httpbin -o yaml
kubectl edit service/httpbin
#Change the service type to NodePort
curl http://192.168.99.101:30092/get
In the DestinationRule settings, you specified maxConnections: 1 and http1MaxPendingRequests: 1. 
These rules indicate that if you exceed more than one connection and request concurrently, 
you should see some failures when the istio-proxy opens the circuit for further requests and connections.
#Now install fortio
#Run it as a docker container
docker run fortio/fortio load http://www.google.com/
#test on our service
docker run fortio/fortio load -c 1 -qps 0 -n 20 -loglevel Warning http://192.168.99.101:30092/get 
docker run fortio/fortio load -c 1 -qps 0 -n 5 -loglevel Warning http://192.168.99.101:30092/get 
docker run fortio/fortio load -c 2 -qps 0 -n 20 -loglevel Warning http://192.168.99.101:30092/get 
docker run fortio/fortio load -c 3 -qps 0 -n 20 -loglevel Warning http://192.168.99.101:30092/get 