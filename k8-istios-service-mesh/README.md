1.	Install istio using curl -L https://git.io/getLatestIstio | sh -
2.	Move to the Istio package directory. For example, if the package is istio-1.0.3:
cd istio-1.0.3
3.	kubectl apply -f install/kubernetes/helm/istio/templates/crds.yaml
4.	Add the istioctl client to your PATH environment variable, on a macOS or Linux system:
export PATH=$PWD/bin:$PATH
5.	
helm template install/kubernetes/helm/istio --name istio --namespace istio-system \
  --set security.enabled=false \
  --set ingress.enabled=true \
  --set gateways.istio-ingressgateway.enabled=true \
  --set gateways.istio-egressgateway.enabled=false \
  --set galley.enabled=false \
  --set sidecarInjectorWebhook.enabled=false \
  --set mixer.enabled=false \
  --set prometheus.enabled=true \
  --set global.proxy.envoyStatsd.enabled=false \
  --set pilot.sidecar=false > $HOME/istio-minimal.yaml
  
6.	kubectl apply -f install/kubernetes/istio-demo.yaml
7.	check the status of services
kubectl get svc -n istio-system
8.	Check the status of pods
kubectl get pods -n istio-system

9.	kubectl label namespace default istio-injection=enabled

10.	Deploy bookinfo application as follows –
kubectl apply -f samples/bookinfo/platform/kube/bookinfo.yaml
 
11.	If you are working on minikube, then you need to setup Ingress as follows.
As local minikube cluster does not support external load balancer, you will have to make use of NodePort service. Setup INGRESS_HOST, INGRESS_SECRET_PORT and INGRESS_PORT as follows.

export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')

export SECURE_INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].nodePort}')

export INGRESS_HOST=$(minikube ip)

12. Access prometheus from localhost	
kubectl -n istio-system port-forward $(kubectl -n istio-system get pod -l app=prometheus -o jsonpath='{.items[0].metadata.name}') 9090:9090
