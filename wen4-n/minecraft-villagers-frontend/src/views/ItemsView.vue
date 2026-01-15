<template>
  <div v-if="!updating" class="page-wrapper">
    <b-card header="Список предметов" class="big-card shadow">
      <b-list-group>
        <b-list-group-item
          v-for="item in items"
          :key="item.id"
          class="d-flex align-items-center"
        >
          <b-container fluid>
            <b-row class="align-items-center">
              <b-col cols="10">
                <item-list-item :item="item" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click="clickDeleteButton(item.id)">
                  <b-icon icon="trash" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="updating = true"
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
  <create-item-view
    v-else
    :startingItem="{
      id: 0,
      name: '',
      quantity: 1,
    }"
    :createItem="completeCreateItem"
    :onReturn="returnToList"
  />
</template>
<script>
import { createItem, deleteItemById, getAllItems } from "../api/items";
import ItemListItem from "../components/ItemListItem.vue";
import CreateItemView from "./CreateItemView.vue";

export default {
  data() {
    return {
      items: [],
      loading: false,
      error: null,
      updating: false,
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
        this.error = "Failed to load items";
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    clickDeleteButton(itemId) {
      deleteItemById(itemId);
      setTimeout(this.loadItems, 500);
    },
    completeCreateItem(item) {
      createItem(item);
    },
    returnToList() {
      this.updating = false;
      setTimeout(this.loadItems, 500);
    },
  },
  components: {
    ItemListItem,
    CreateItemView,
  },
};
</script>
