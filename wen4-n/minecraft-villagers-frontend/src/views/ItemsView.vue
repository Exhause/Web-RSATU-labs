<template>
  <div class="page-wrapper">
    <b-card header="Список предметов" class="big-card shadow">
      <b-list-group>
        <template v-for="item in items">
          <b-list-group-item :key="item.id" class="d-flex align-items-center">
            <b-container fluid>
              <div>
                Название: <strong>{{ item.name }}</strong>
              </div>
              <div>
                Количество: <strong>{{ item.quantity }}</strong>
              </div>
            </b-container>
          </b-list-group-item>
        </template>
      </b-list-group>
      <template v-if="loading">
        <p>Loading...</p>
      </template>
      <template v-if="error !== null">
        <p>Error! {{ error }}</p>
      </template>
    </b-card>
  </div>
</template>
<script>
import { getAllItems } from "../api/items";

export default {
  data() {
    return {
      items: [],
    };
  },
  mounted() {
    this.loadItems();
  },
  methods: {
    async loadItems() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getAllItems();
        this.items = res.data;
      } catch (e) {
        this.error = `Failed to load items`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>
