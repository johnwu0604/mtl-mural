#MTL Mural

#Inspiration
Concrete, potholes, and traffic jams. We've created a way to find the diamonds in the rough amongst an evergrowing, urban metropolis.

#What it does
Simply open up the app, and check for beautiful murals in the vicinity.

The app opens up to a map with all of the current murals present in Montreal. Find murals near you by clicking on the red tags for a preview and some interesting facts.

#How we built it
The city of Montreal provides open data for all of its current murals, found in this JSON file: http://donnees.ville.montreal.qc.ca/dataset/murales/resource/d325352b-1c06-4c3a-bf5e-1e4c98e0636b Java was used to parse the JSON open data and create a list of Mural objects. The methods were called in Android Studio to obtain the list of murals and populate them on the google map using the Google Maps API. Clicking on a tag on the map opens up a page with the address and some additional information about each mural.
