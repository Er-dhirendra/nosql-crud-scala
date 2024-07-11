# Use the official MongoDB image from Docker Hub
FROM mongo

# Copy your dataset into the Docker image
COPY MOCK_DATA.json /sample_data.json

# Specify the database name and collection name
ENV MONGO_INITDB_DATABASE=mydb
ENV MONGO_INITDB_COLLECTION=mycollection

# Import the dataset into MongoDB when the container launches
CMD mongoimport --host mongodb --db $MONGO_INITDB_DATABASE --collection $MONGO_INITDB_COLLECTION --type json --file /sample_data.json --jsonArray
