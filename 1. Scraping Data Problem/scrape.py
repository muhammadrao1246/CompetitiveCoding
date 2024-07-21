from io import StringIO
import requests
import pandas as pd
from bs4 import BeautifulSoup

df = pd.DataFrame(columns=['test1', 'test2'])
URL = "https://afltables.com/afl/teams/adelaide/allgames_tm.html"
print(URL)
page = requests.get(URL)

soup = BeautifulSoup(page.content, "html.parser")

# ALL SORTABLE TABLES
tables = soup.select(".sortable")

# WILL BE HOLDING CONTENT for against each club by key
tables_record_dict =  {}


for table in tables:
    # creating df by providing table content and choosing Rnd, T line as header
    df = pd.read_html(StringIO(str(table)), header=0)[0].drop(0)
    club_name = table.select_one("thead").select_one("th").text
    print(club_name)
     
    tables_record_dict[club_name] = df


print(tables_record_dict)