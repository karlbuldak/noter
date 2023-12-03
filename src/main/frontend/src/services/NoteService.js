import axios from "axios";

const NOTES_API_BASE_URL = 'http://localhost:8080/api/'

class NoteService{
    getNote(slug){
        return axios.get(`${NOTES_API_BASE_URL}${slug}`)
            .then(response => {
                return response.data;
            })
            .catch(error => {
                console.error(error);
                throw error;
            })
    
    }
}

export default new NoteService()