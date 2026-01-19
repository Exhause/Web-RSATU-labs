<template>
  <div class="page-wrapper">
    <b-card header="Редактирование предмета" class="big-card shadow">
      <item-form
        v-if="item !== null"
        :initialItem="item"
        :onCancel="onCancel"
        :onSave="onSave"
      />
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
import { getItemById, updateItem } from "../api/items";
import ItemForm from "../components/ItemForm.vue";

export default {
  props: ["id"],
  data() {
    return {
      item: null,
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadItem();
  },
  methods: {
    async loadItem() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getItemById(this.id);
        this.item = res.data;
      } catch (e) {
        this.error = `Failed to load item with id = ${this.id}`;
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    onCancel() {
      this.$router.push("/items");
    },
    async onSave(item) {
      await updateItem(item);
      this.$router.push("/items");
    },
  },
  components: {
    ItemForm,
  },
};
</script>
