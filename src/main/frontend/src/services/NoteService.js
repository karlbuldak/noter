import axios from "axios";

const NOTES_API_BASE_URL = 'http://localhost:8080/api'

class NoteService{
    getNote(slug){
        return axios.get(`${NOTES_API_BASE_URL}${slug}`)
    }
}

export default new NoteService()