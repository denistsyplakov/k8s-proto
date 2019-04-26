




## GCP config

### local run

Each developer defines variable GOOGLE_APPLICATION_CREDENTIALS and points it to his/her file 
with proper GCP creds.

### docker run 

Currently containers are stored locally (could be stored locally in your case). Embed GCP creds inside
a container is not a good idea. 

GCP creds should be placed in the file gcp.json the same directory as application.properties. 
Docker image has env variable GOOGLE_APPLICATION_CREDENTIALS=/config/gcp.json


### K8s

In K8S we are injecting gcp.json into service /config directory via K8S ConfigMap