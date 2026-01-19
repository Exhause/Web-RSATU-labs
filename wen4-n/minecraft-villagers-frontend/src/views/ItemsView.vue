<template>
  <div class="page-wrapper">
    <b-card header="Список предметов" class="big-card shadow">
      <b-list-group>
        <b-list-group-item
          v-for="item in items"
          :key="item.id"
          class="d-flex align-items-center"
        >
          <b-container fluid>
            <b-row class="align-items-center">
              <b-col cols="8">
                <item-list-item :item="item" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="primary" @click="onClickUpdate(item.id)">
                  <b-icon icon="pencil" />
                </b-button>
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click="onDelete(item.id)">
                  <b-icon icon="trash" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="onClickCreate()"
        >
          <b-container fluid> Создать новый предмет </b-container>
        </b-list-group-item>
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
import { deleteItemById, getAllItems } from "../api/items";
import ItemListItem from "../components/ItemListItem.vue";

export default {
  data() {
    return {
      items: [],
      loading: false,
      error: null,
    };
  },
  created() {
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
        this.error = "Failed to load items";
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    async onDelete(itemId) {
      await deleteItemById(itemId);
      this.loadItems();
    },
    onClickUpdate(itemId) {
      this.$router.push(`/items/${itemId}/update`);
    },
    onClickCreate() {
      this.$router.push("/items/create");
    },
  },
  components: {
    ItemListItem,
  },
};
</script>
