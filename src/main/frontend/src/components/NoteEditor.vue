<template>
    <div id="editor">
     <editor
       api-key="h9g8j5qd5wap3iov2k5sify0p509xo5wj5y31g00jhxpm5cd"
       :init="{
         height: 500,
         menubar: false,
         plugins: [
           'advlist autolink lists link image charmap print preview anchor',
           'searchreplace visualblocks code fullscreen',
           'insertdatetime media table paste code help wordcount'
         ],
         toolbar:
           'undo redo | formatselect | bold italic backcolor | \
           alignleft aligncenter alignright alignjustify | \
           bullist numlist outdent indent | removeformat | help'
       }"
     />
   </div>
   <br>
   <button v-on:click="saveNote" class="button-6">Save Note</button>
</template>
<script>
import Editor from '@tinymce/tinymce-vue';
import NoteService from '@/services/NoteService';
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/'


export default {
  name: 'NoteEditor',
  components: {
    'editor': Editor
  },
  methods: {
    async saveNote(){
        const postContent = () => {
  const content = tinymce.activeEditor.getContent();

  // You can customize headers or other Axios configurations as needed
  const config = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  // Assuming you want to send the content as JSON in the request body
  const data = {
    content: content,
  };

  return axios.post(API_BASE_URL, data, config)
    .then(response => {
      console.log('Post successful:', response.data);
      // Handle success response as needed
    })
    .catch(error => {
      console.error('Error posting content:', error);
      // Handle error or show an error message
      throw error;
    });
};
    }
  }
};
</script>
<style>
#editor {
      width: 70%;
      margin: 0 auto; 
    }

.button-6 {
  align-items: center;
  background-color: #FFFFFF;
  border: 1px solid rgba(0, 0, 0, 0.1);
  border-radius: .25rem;
  box-shadow: rgba(0, 0, 0, 0.02) 0 1px 3px 0;
  box-sizing: border-box;
  color: rgba(0, 0, 0, 0.85);
  cursor: pointer;
  display: inline-flex;
  font-family: system-ui,-apple-system,system-ui,"Helvetica Neue",Helvetica,Arial,sans-serif;
  font-size: 16px;
  font-weight: 600;
  justify-content: center;
  line-height: 1.25;
  margin: 0;
  min-height: 3rem;
  padding: calc(.875rem - 1px) calc(1.5rem - 1px);
  position: relative;
  text-decoration: none;
  transition: all 250ms;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: baseline;
  width: auto;
}

.button-6:hover,
.button-6:focus {
  border-color: rgba(0, 0, 0, 0.15);
  box-shadow: rgba(0, 0, 0, 0.1) 0 4px 12px;
  color: rgba(0, 0, 0, 0.65);
}

.button-6:hover {
  transform: translateY(-1px);
}

.button-6:active {
  background-color: #F0F0F1;
  border-color: rgba(0, 0, 0, 0.15);
  box-shadow: rgba(0, 0, 0, 0.06) 0 2px 4px;
  color: rgba(0, 0, 0, 0.65);
  transform: translateY(0);
}
</style>