document.getElementById('saveButton').addEventListener('click', postNote);

tinymce.init({
    selector: 'textarea#tiny',
    skin: "bootstrap"
});

function getContent(){
    return tinymce.get('tiny').getContent()
}

function postNote(){
    const content = getContent();
    fetch('http://localhost:8080/notes', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                "author":"test",
                "content":content
            })
    })
        .then(response => response.json())
        .then(response => console.log(JSON.stringify(response)))
}
