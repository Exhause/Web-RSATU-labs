<script setup></script>

<template>
  <div id="app">
    <nav>
      <b-navbar variant="dark" class="position-relative">
        <router-link to="/">
          <b-button variant="dark">Деревни</b-button></router-link
        >
        <router-link to="/items"
          ><b-button variant="dark">Предметы</b-button></router-link
        >
        <router-link to="/deals"
          ><b-button variant="dark">Сделки</b-button></router-link
        >
      </b-navbar>
    </nav>
    <main class="content"><router-view /></main>
  </div>
</template>
