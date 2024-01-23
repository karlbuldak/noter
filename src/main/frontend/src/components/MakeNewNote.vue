<template>
  <div>
    <form @submit.prevent="createAndShowNote">
      <div>
        <label for="author">Type authors name:</label>
        <br>
        <input type="text" id="author" v-model="post.author" />
      </div>
      <div>
        <label for="content">Note something:</label>
        <br>
        <textarea type="text" id="content" v-model="post.content" />
      </div>
      <br>
      <button class="button">Create Note</button>
    </form>
  </div>
  <Footer />
</template>

<script>
import Footer from './Footer.vue';
import Swal from 'sweetalert2'
import axios from 'axios';
const API_POST_URL = 'http://localhost:8080/api/note-create';
const headers = {
    'Content-Type': 'application/json',
  };



export default {
  components:{
    Footer
  },
  name: 'NoteEditor',
  data() {
    return {
      post: {
        author: '',
        content: ''
      }
    };
  },
  methods: {
  createNote() {
    Swal.fire({
      title: "Note succesfully created!",
      text: "Now you can share it with friends!",
      icon: "success",
      timer: 1000,
      showConfirmButton: false
    });
    const promise = axios.post(API_POST_URL, this.post, { headers });
    const dataPromise = promise.then((response) => response.data);
    return dataPromise;
},
  createAndShowNote() {
    this.createNote()
      .then(data => {
        const slug = data.slug;
        this.$router.push(`/note/${slug}`);
      })
      .catch(error => {
        console.error(error);
      });
  }
}
}
</script>
<style>
h2#swal2-title
      {
         font-size: 24px;
         font-family: system-ui,-apple-system,system-ui,"Helvetica Neue",Helvetica,Arial,sans-serif;
        color:theme('colors.metal');
      }
      div#swal2-html-container{
         font-size: 16px;
         font-family: system-ui,-apple-system,system-ui,"Helvetica Neue",Helvetica,Arial,sans-serif;
         color: theme('colors.metal');
      }
  #delete{
    background-color: #dc3545;
    color: #fefefa;
  }
#author{
  width: 15%;
  height: 20px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
}
textarea {
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  resize: none;
  height:300px;
  width: 50%;
}

label{
  font-size:20px;
  
}

.button {
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

.button:hover,
.button:focus {
  border-color: rgba(0, 0, 0, 0.15);
  box-shadow: rgba(0, 0, 0, 0.1) 0 4px 12px;
  color: rgba(0, 0, 0, 0.65);
}

.button:hover {
  transform: translateY(-1px);
}

.button:active {
  background-color: #F0F0F1;
  border-color: rgba(0, 0, 0, 0.15);
  box-shadow: rgba(0, 0, 0, 0.06) 0 2px 4px;
  color: rgba(0, 0, 0, 0.65);
  transform: translateY(0);
}
</style>