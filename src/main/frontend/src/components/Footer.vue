<!-- MyFooter.vue -->

<template>
    <footer>
      <p>
        Designed by <strong>Karol Bułdak </strong> ┃
        <a @click="sendEmail" href="mailto:karolbuldak@gmail.com"> karolbuldak@gmail.com</a>
      </p>
      
    </footer>
  </template>
  
  <script>
  export default {
    methods: {
      sendEmail() {
        window.location.href = 'mailto:karolbuldak@gmail.com';
      },
    },
  };
  </script>
  
  <style scoped>
  a{
    text-decoration: none;
    color: black;
  }
  p{
    font-size: small;
  }
  footer {
    background-color: #C2EDDA;
    padding: 10px;
    text-align: center;
    position: fixed;
    bottom: 0;
    width: 100%;
  }
  </style>
  