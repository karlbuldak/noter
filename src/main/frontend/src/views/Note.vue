<template>
    <div class="notes">
        <h1>This is your note {{ id }}</h1>
        <h1 v-if="noteData">This is your note: <br> id: {{ noteData.id }} <br> author: {{ noteData.author }} 
            <br> content: {{ noteData.content }} <br> slug: {{ noteData.slug }} </h1>
        <div v-else>Loading...</div>
    </div>
</template>

<script>
import NoteService from '../services/NoteService'

export default{
    data() {
        return {
            id: this.$route.params.slug,
            noteData: this.data
        };
    },
    mounted() {
        NoteService.getNote(this.$route.params.slug)
        .then(data => {
                this.noteData = data;
                console.log(data)
            })
            .catch(error => {
                console.error(error);
            });
    }
}
</script>
  