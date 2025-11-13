from flask import Flask, jsonify, request

#Créer l'application flask
app = Flask(__name__)

#Sauvegarder les étudiants dans une liste 
students=[
    {"id":1, "prenom":"Samir", "age":54},
    {"id":2, "prenom":"Safa", "age":22}
    ]

#Définir la racine de l'API ...
@app.route('/')
def home():
    return "C'est cool REST !"

#Donner au client ce qu'il y a dans le dossier message 
@app.route('/message')
def message():
    return "<h1>Bonjour tout le monde ! </h1>"

#Pour afficher la liste des étudiants
@app.route('/students', methods=['GET'])#Le "methods" sert de bonne pratique pour spécifier que c'est obtenu à partir de la méthode get
def get_students():
    return jsonify(students)

#Ajouter nouvel étudiant à la liste 
@app.route('/students', methods=['POST'])
def add_student():
    new_student = request.get_json()#récupérer l'objet
    new_student['id'] = len(students)+1 #Assigner un ID automatique
    students.append(new_student)
    return jsonify (new_student),201 #Bonne pratique

#afficher un étudiant sachant son identifiant
@app.route('/students/<int:id>', methods=['GET'])
def get_student(id):
    #Cherche le premier étudiant ayant l'id demandé dans la liste 
    student = next((s for s in students if s['id']==id), None)
    if student:
        return jsonify(student)
    return jsonify({"erreur": "L'étudiant n'est pas trouvé"}), 404

#Cette méthode permet de mettre à jour les étudiants 
@app.route('/students/<int:id>', methods=['PUT'])#déclare une route Falk qui répond aux requêtes HTTP PUT
def update_student(id): #fonction qui sera appelée lorsqu'une requête PUT ets faite
    student = next((s for s in students if s['id']==id), None)
    if not student:
        return jsonify({"erreur":"not exist"}),404#indiquer l'erreur 404 pour adopter les bonnes pratiques
    
    data = request.get.json()#récupère les données JSON envoyées dans le cors de la requête put
    student.update(data)#met à jour l'objet student avec les données reçues
    return jsonify(student)  #revoie le dictionnaire mis à jour sous forme JSON au client 

#Cette méthode permet d'effacer un étudiant 
@app.route('/students/<int:id>', methods=['DELETE'])
def delete_student(id):
    global students
    students = [s for s in students if s['id'] != id]
    return jsonify ({"message":"ok"}),200
if __name__=='__main__':
    app.run(debug=True)