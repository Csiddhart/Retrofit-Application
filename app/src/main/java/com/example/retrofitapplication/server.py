from flask import Flask, jsonify, request, send_file
import openai


app=Flask(__name__)

api_key="OPENAI_API_KEY"


openai.api_key="YOUR_API_KEY" #here give your own openaiapikey

@app.route('/api/hello/<question>',methods=['GET'])
def hello(question):
    answer=chatGptFun(question) #here we are setting that for every question we should be getting answer
    return jsonify(answer)

def chatGptFun(question):
 response=openai.ChatCompletion.create(
    model="gpt-3.5-turbo",
    messages=[
        {"role":"system","content":"You are a helpful assistant"},
        {"role":"user","content":question},
    ]
)
 return response['choices'][0]['message']['content']

app.run()