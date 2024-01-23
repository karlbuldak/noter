<template>
    <h1>Noter - viewing your note</h1>
    <div class="notes">
        <div v-if="noteData">
            <h2 id="info">This is your note {{ noteData.slug }}</h2>
            <h2>Author:</h2>
            <p>{{ noteData.author }} </p>
            <h2>Content:</h2>
            <p>{{ noteData.content }} </p>
            <button @click="editNote" class="button">Edit your Note</button>
            <button @click="shareNote" class="button" id="share">Share your note!</button>
        </div>
        <div  v-else>
            <h1>We are sorry, we couldn't find your note. Try again, or...</h1>
            <button @click="NewNote" class="button">Make new note</button>
        </div>
    </div>
    <Footer />

    
</template>

<script>
import Footer from '@/components/Footer.vue';
import NoteService from '../services/NoteService'

export default{
  components:{
    Footer
  },
    data() {
        return {
            slug: this.$route.params.slug,
            noteData: this.data
        };
    },
    mounted() {
        NoteService.getNote(this.$route.params.slug)
        .then(data => {
                this.noteData = data;
            })
            .catch(error => {
                console.error(error);
            });
    },
    methods: {
        editNote(){
            this.$router.push(`/note/${this.slug}/edit`);
        },
        shareNote(){
            const shareButton = document.querySelector("#share")
            const link = `noter.pl/${this.slug}`
            navigator.clipboard.writeText(link);
            shareButton.innerHTML = "Copied!"
            setTimeout(() => (shareButton.innerHTML = "Share your note!"), 700)
        },
        NewNote(){
            this.$router.push(`/`);
        }
    }
}
</script>
<style>
h2{
    font-weight: bold;
}
p{
    font-size:x-large;
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
  