# Wikipedia Article Count Words

Using an _HTTP GET_ method, retrieve information from Wikipedia using a given topic. Query https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic] to get the _topic_ Wikipedia article. Print the total number of times that the string _topic_ appears in the article's text field.

Note: te search is case-sensitive.

The query response from the website is a JSON object described below:
  - _parse_: A JSON object representing the article's parsed web page. It has the following three fields:
    1. _title_: The article's title, as specified by the argument passed as _topic_
    2. _pageid_: The article's Page ID
    3. _text_: A JSON object that contains the Wikipedia article as an HTML dump
    
 ### Example:
 
 Input: pizza -> topic = 'pizza'
 
 Output: 149 (this number might be incorrect, is just used as an example)
 
 
