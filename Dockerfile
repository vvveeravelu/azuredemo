################################################################################
# Dockerfile used to automatically build the  application docker image.
#
# @since 1.0.0
# @author VIkram Veeravelu
# 
################################################################################
FROM openjdk:11-jdk


RUN apt-get install findutils openssl unzip



RUN mkdir -p /home/ec2-user/azuredemo-docker-image

# Add item-service jar to the image
ADD azuredemo-0.0.1-SNAPSHOT.jar /home/ec2-user/azuredemo-docker-image/azuredemo-0.0.1-SNAPSHOT.jar

# startup script
RUN printf "%s\n\n" 'java -jar /home/ec2-user/azuredemo-docker-image/azuredemo-0.0.1-SNAPSHOT.jar' > /home/ec2-user/azuredemo-docker-image/azuredemo-docker-start.sh

# Update permissions on start script to allow execution
RUN chmod +x /home/ec2-user/azuredemo-docker-image/azuredemo-docker-start.sh

# Touch jar file to change the file timestamp to represent time of packaging
RUN sh -c 'touch /home/ec2-user/azuredemo-docker-image/azuredemo-0.0.1-SNAPSHOT.jar'



# Inform Docker that the container listens on network port 8443 at runtime (this does not make the ports of the container accessible to the host)
EXPOSE 8080

# Specify the command to be run on container startup
ENTRYPOINT ["/bin/bash", "-c", "/home/ec2-user/azuredemo-docker-image/azuredemo-docker-start.sh"]

#FROM openjdk:11-jdk
#COPY C:/Z_VIKRAM_PERSONAL_DATA/Z_My_WorkArea/Azure_SpringBoot/azuredemo/azuredemo/build/libs/azuredemo-0.0.1-SNAPSHOT.jar azuredemo-0.0.1.jar
#ENTRYPOINT ["java","-jar","/azuredemo-0.0.1.jar"]
