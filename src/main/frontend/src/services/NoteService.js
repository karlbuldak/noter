import axios from "axios";

const API_BASE_URL = 'http://localhost:8080/api/note/'

class NoteService{
    async getNote(slug){
        try {
        const response = await axios.get(`${API_BASE_URL}${slug}`);
        return response.data;
      } catch (error) {
        console.error(error);
        throw error;
      }
    }
    NewNote(){
      this.$router.push(`/`);
  }
}

export default new NoteService()
