<template>
    <div class="editor">
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
   <button>Save Note</button>
</template>
<script>
import Editor from '../../node_modules/@tinymce/tinymce-vue'

export default {
  name: 'NoteEditor',
  components: {
    'editor': Editor
  }
}
</script>
<style>
.editor {
      width: 70%;
      margin: 0 auto; 
    }
</style>