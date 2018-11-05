#Hackthon 2018
# Author - Sneha Mishra
# Date of Creation - Nove 3rd 2018
# Details - this code uses Curl utility to call maid rest API and a config file to read all the state abb to call the API's in loop
# usage- sh code name
#####################################################################################################################################


# for loop for reading states code in united states_code config file
echo " program to fetch all the json is starting in a loop "

for v in `cat united_states_code.dat`
do
# curl utility for calling REST APIA

echo " calling curl api and medicad rest api"
curl  https://data.medicaid.gov/resource/rk4x-vkz6.json?state_code=$v > $v.json

done

echo " the json for all the states have been fetch and stored in location"






